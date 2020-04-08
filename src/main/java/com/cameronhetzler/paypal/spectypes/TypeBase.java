package com.cameronhetzler.paypal.spectypes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.cameronhetzler.paypal.common.JSONFormatter;
import com.cameronhetzler.paypal.exceptions.ServicesException;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Cameron Hetzler
 *
 * @param <T>
 */
public abstract class TypeBase<T> {

	@Getter @Setter
	protected T instance;
	@Getter @Setter
	protected List<T> instanceList;
	
	public TypeBase(T instance) {
		this.instance = instance;
	}
	
	public TypeBase(List<T> instanceList) {
		this.instanceList = instanceList;
	}
	
	protected void save(String jsonFile, T instance) throws IOException, ServicesException {
		BufferedWriter bw = null;
		try {
			String jsonString = JSONFormatter.toJSON(instance);
			bw = new BufferedWriter(new FileWriter(new File(
					getClass().getClassLoader().getResource(jsonFile).getFile())));
			
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
			bw = new BufferedWriter(new FileWriter(new File(
					getClass().getClassLoader().getResource(jsonFile).getFile())));
			
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
	
	protected <C> C load(String jsonFile, Class<C> clazz) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					getClass().getClassLoader().getResource(jsonFile).getFile())));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
		
			while (line != null) {
				sb.append(line);
				sb.append(System.getProperty("line.separator"));
				line = br.readLine();
			}
			return (C)JSONFormatter.fromJSON(sb.toString(), clazz);
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
	
	protected <C> List<C> load(String jsonFile, Type clazz) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					getClass().getClassLoader().getResource(jsonFile).getFile())));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
		
			while (line != null) {
				sb.append(line);
				sb.append(System.getProperty("line.separator"));
				line = br.readLine();
			}
			return JSONFormatter.fromJSON(sb.toString(), clazz);
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
}