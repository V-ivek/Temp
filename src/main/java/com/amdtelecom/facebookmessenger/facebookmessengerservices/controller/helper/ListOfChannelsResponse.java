package com.amdtelecom.facebookmessenger.facebookmessengerservices.controller.helper;

import java.util.List;

public class ListOfChannelsResponse {
	
	private List<GenericChannelResponse> channels;
	private Integer totalPages;
	private boolean last;
	private Integer totalElements;
	private boolean first;
	private Integer size;
	private Integer number;
	
	public ListOfChannelsResponse(List<GenericChannelResponse> channels, Integer totalPages, boolean last,
			Integer totalElements, boolean first, Integer size, Integer number) {
		this.channels = channels;
		this.totalPages = totalPages;
		this.last = last;
		this.totalElements = totalElements;
		this.first = first;
		this.size = size;
		this.number = number;
	}

	public List<GenericChannelResponse> getChannels() {
		return channels;
	}

	public void setChannels(List<GenericChannelResponse> channels) {
		this.channels = channels;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
