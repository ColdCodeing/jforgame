package com.kingston.net;

import com.kingston.net.annotation.MessageMeta;

/**
 * base class of IO message
 */
public abstract class Message {

	/**
	 * messageMeta, module of message
	 * @return
	 */
	public short getModule() {
		MessageMeta annotation = getClass().getAnnotation(MessageMeta.class);
		if (annotation != null) {
			return annotation.module();
		}
		return 0;
	}

	/**
	 * messageMeta, subType of message
	 * @return
	 */
	public short getCmd() {
		MessageMeta annotation = getClass().getAnnotation(MessageMeta.class);
		if (annotation != null) {
			return annotation.cmd();
		}
		return 0;
	}

	public String key() {
		return this.getModule() + "_" + this.getCmd();
	}

}
