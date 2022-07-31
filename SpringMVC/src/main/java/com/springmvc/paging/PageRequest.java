//package com.springmvc.paging;
//
//import com.springmvc.sorter.Sorter;
//
//public class PageRequest implements Pageable {
//	private Integer page;
//	private Integer limitItems;
//	private Sorter sorter;
//
//	public PageRequest(Integer page, Integer limitItems, Sorter sorter) {
//		this.page = page;
//		this.limitItems = limitItems;
//		this.setSorter(sorter);
//	}
//
//	@Override
//	public Integer getPage() {
//		return page;
//	}
//
//	@Override
//	public Integer getOffset() {
//		return (page != null && limitItems != null) ? (page - 1) * limitItems : null;
//	}
//
//	@Override
//	public Integer getLimit() {
//		return limitItems;
//	}
//
//	public Sorter getSorter() {
//		if (sorter != null && sorter.getSortField() != null && sorter.getSortBy() != null) {
//			return sorter;
//		}
//		return null;
//	}
//
//	public void setSorter(Sorter sorter) {
//		this.sorter = sorter;
//	}
//
//}
