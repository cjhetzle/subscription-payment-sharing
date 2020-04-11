package com.cameronhetzler.paypal.spectypes;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.payments.Patch;

public class PatchType extends BaseType<Patch> {
	
	public static enum OP {
		
		ADD("ADD"),
		REMOVE("REMOVE"),
		REPLACE("REPLACE"),
		MOVE("MOVE"),
		COPY("COPY"),
		TEST("TEST");
		
		private String value;
		
		private OP(String value) {
			this.value = value;
		}
		
		public String toString() {
			return value.toLowerCase();
		}
	}

	public PatchType() {
		super(new Patch());
	}

	public Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Patch>>() {}.getType();
	}

	public Class<Patch> getType() {
		// TODO Auto-generated method stub
		return Patch.class;
	}
}
