package com.chenjw.knife.agent.handler;

import java.net.URLDecoder;

import com.chenjw.knife.agent.Agent;
import com.chenjw.knife.agent.core.CommandDispatcher;
import com.chenjw.knife.agent.core.CommandHandler;
import com.chenjw.knife.agent.core.ServiceRegistry;
import com.chenjw.knife.agent.service.ObjectHolderService;
import com.chenjw.knife.agent.utils.ResultHelper;
import com.chenjw.knife.core.args.ArgDef;
import com.chenjw.knife.core.args.Args;

public class DecodeCommandHandler implements CommandHandler {

	public void handle(Args args, CommandDispatcher dispatcher)
			throws Exception {
		String str = args.arg("string-to-decode");
		String decodeStr = URLDecoder.decode(str, "UTF-8");
		Agent.sendResult(ResultHelper.newResult("[decode] "
				+ ServiceRegistry.getService(ObjectHolderService.class).toId(
						decodeStr) + " " + decodeStr));
	}

	public void declareArgs(ArgDef argDef) {

		argDef.setDefinition("decode <string-to-decode>");

	}
}
