package com.zeus.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeLabelValue {
	private String label;
	private String value;
}
