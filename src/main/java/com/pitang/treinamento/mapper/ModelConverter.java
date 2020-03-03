package com.pitang.treinamento.mapper;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

public class ModelConverter {

	private ModelConverter() {
		throw new IllegalStateException("Utility class");
	}

	public static final Converter<Boolean, String> convertStatus = new AbstractConverter<Boolean, String>() {
		@Override
		protected String convert(Boolean source) {
			if (source) {
				return "Ativo";
			} else {
				return "Inativo";
			}
		}
	};

	public static final Converter<String, Boolean> convertStatusToBoolean = new AbstractConverter<String, Boolean>() {
		@Override
		protected Boolean convert(String source) {
			if (source.equals("Ativo")) {
				return true;
			} else {
				return false;
			}
		}
	};

	public static final Converter<LocalDateTime, String> fromDatetimeToString = new AbstractConverter<LocalDateTime, String>() {
		@Override
		protected String convert(LocalDateTime source) {
			if (source == null) {
				return null;
			}
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
			String dataFormatada = formatterData.format(agora);

			return dataFormatada;
		}
	};


	public static final Converter<String, LocalDateTime> fromStringToDatetime = new AbstractConverter<String, LocalDateTime>() {
		@Override
		protected LocalDateTime convert(String source) {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
				LocalDateTime date = LocalDateTime.parse(source, formatter);
				return date;

			} catch (Exception e) {

				System.out.println("ERRO na conversão -> " + e.getMessage());

				return null;
			}
		}
	};
}