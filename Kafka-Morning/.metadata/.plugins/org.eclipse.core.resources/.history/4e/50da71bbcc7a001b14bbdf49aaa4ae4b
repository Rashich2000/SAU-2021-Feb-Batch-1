package com.accolite.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.accolite.domain.LibraryEvent;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LibraryEventDeserializer implements Deserializer<LibraryEvent>{

	@Override
	public LibraryEvent deserialize(String topic, byte[] data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

		LibraryEvent msg = null;
		try {
			msg = objectMapper.readValue(data, LibraryEvent.class);
		} catch (Exception e) {
			System.out.println("Exception while reading value"+e);
		}

		return msg;
	}

}
