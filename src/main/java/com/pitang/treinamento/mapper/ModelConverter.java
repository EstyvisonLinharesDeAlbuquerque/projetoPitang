package com.pitang.treinamento.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
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

	public static final Converter<LocalDate, String> fromDateToString = new AbstractConverter<LocalDate, String>() {
		@Override
		protected String convert(LocalDate source) {
			if (source == null) {
				return null;
			}
			// data/hora atual
			LocalDate hoje = LocalDate.now();
			// formatar a data
			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			String dataFormatada = formatterData.format(hoje);

			return dataFormatada;
		}
	};

	public static final Converter<LocalTime, String> fromTimeToString = new AbstractConverter<LocalTime, String>() {
		@Override
		protected String convert(LocalTime source) {
			if (source == null) {
				return null;
			}
			// data/hora atual
			LocalTime agora = LocalTime.now();
			// formatar a data
			DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
			String horaFormatada = formatterTime.format(agora);

			return horaFormatada;
		}
	};

	public static final Converter<String, LocalDate> fromStringToDate = new AbstractConverter<String, LocalDate>() {
		@Override
		protected LocalDate convert(String source) {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				LocalDate date = LocalDate.parse(source, formatter);
				return date;

			} catch (Exception e) {

				System.out.println("ERRO na conversão -> " + e.getMessage());

				return null;
			}
		}
	};

	public static final Converter<String, LocalTime> fromStringToTime = new AbstractConverter<String, LocalTime>() {
		@Override
		protected LocalTime convert(String source) {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime hour = LocalTime.parse(source, formatter);
				return hour;

			} catch (Exception e) {

				System.out.println("ERRO na conversão -> " + e.getMessage());

				return null;
			}
		}
	};
}