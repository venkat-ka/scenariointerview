package com.scenario.interview.entity;


public class PriorityStudenRankEntity implements Comparable<PriorityStudenRankEntity> {
	private int id;
	private String name;
	private int rank;
	public PriorityStudenRankEntity(int id, String name, int rank) {
		super();
		this.id = id;
		this.name = name;
		this.rank = rank;
	}
	public PriorityStudenRankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public int compareTo(PriorityStudenRankEntity o) {
		// TODO Auto-generated method stub
		if(rank < o.rank)
		return -1;
		else if(rank > o.rank)
		return 1;
		else
		return 0;	
	}
	@Override
	public String toString() {
		return "PriorityStudenRankEntity [id=" + id + ", name=" + name + ", rank=" + rank + "]";
	}
	
	
}
