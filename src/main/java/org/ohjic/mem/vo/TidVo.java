package org.ohjic.mem.vo;

import org.ohjic.mem.model.Kyo;

public class TidVo extends Kyo {

	private Integer tid;

	public TidVo() {
		
	}
	
	public TidVo(Integer churchCode) {
		super(churchCode);
	}
	
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
}
