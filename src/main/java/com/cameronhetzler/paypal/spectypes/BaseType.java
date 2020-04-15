package com.cameronhetzler.paypal.spectypes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.cameronhetzler.paypal.common.JSONFormatter;
import com.cameronhetzler.paypal.exceptions.ServicesException;

import lombok.Setter;

/**
 * 
 * @author Cameron Hetzler
 *
 * @param <T>
 */
public abstract class BaseType<T> implements BaseTypeInt<T> {

	@Setter
	protected T instance;
	@Setter
	protected List<T> instanceList;

	private String fileString;

	/**
	 * Return a single instance. If instance is null,
	 * try to pull from the list of instances. If that is null,
	 * return null.
	 * 
	 * @return T
	 */
	public T getInstance() {
		return instance != null ? instance : instanceList != null ? instanceList.get(0) : null;
	}

	/**
	 * Return a list of instances. If instanceList is null,
	 * try to make a list from instance. If instance is null,
	 * return null.
	 * 
	 * @return List<T>
	 */
	@SuppressWarnings("unchecked")
	public List<T> getInstanceList() {
		return instanceList != null ? instanceList : instance != null ? Arrays.asList(instance) : null;
	}

	public BaseType(T instance) {
		this.instance = instance;
	}

	public BaseTypeInt<T> create(String jsonFile) throws ServicesException {
		try {
			setInstanceList(load(jsonFile, getListType()));
		} catch (Exception e) {
			setInstance(load(jsonFile, getType()));
		}
		return this;
	}

	protected void save(String jsonFile, T instance) throws IOException, ServicesException {
		BufferedWriter bw = null;
		try {
			String jsonString = JSONFormatter.toJSON(instance);
			bw = new BufferedWriter(
					new FileWriter(new File(getClass().getClassLoader().getResource(jsonFile).getFile())));

			bw.write(jsonString);
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void save(String jsonFile, List<T> instanceList) throws IOException {
		BufferedWriter bw = null;
		try {
			String jsonString = JSONFormatter.toJSON(instanceList);
			bw = new BufferedWriter(
					new FileWriter(new File(getClass().getClassLoader().getResource(jsonFile).getFile())));

			bw.write(jsonString);
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String load(String jsonFile) throws ServicesException {

		if (fileString != null)
			return fileString;

		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new FileReader(new File(getClass().getClassLoader().getResource(jsonFile).getFile())));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.getProperty("line.separator"));
				line = br.readLine();
			}

			fileString = sb.toString();

			return fileString;
		} catch (IOException e) {
			ServicesException se = new ServicesException("Error Reading File.", null, e);
			throw se;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected T load(String jsonFile, Class<T> clazz) throws ServicesException {
		this.load(jsonFile);

		T obj = JSONFormatter.fromJSON(fileString, clazz);

		fileString = null;

		return obj;
	}

	protected List<T> load(String jsonFile, Type type) throws ServicesException {
		this.load(jsonFile);

		List<T> obj = JSONFormatter.fromJSON(fileString, type);

		fileString = null;

		return obj;
	}
}
