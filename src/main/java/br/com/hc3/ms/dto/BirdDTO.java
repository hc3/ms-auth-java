package br.com.hc3.ms.dto;

import lombok.Data;

@Data
public class BirdDTO {

	private Long id;
	private String name;
	private String singing;
	private byte[] photo;
}
