package net.kkwcloud.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	
	//field
	private List<SampleDTO> list;
	
	//constructor
	public SampleDTOList() {
		list = new ArrayList<>();
		
		// SampleDTOList 객체를 생성하면 List<SampleDTO> List = new ArrayList<SampleDTO>();
	}
	
	//method
}
