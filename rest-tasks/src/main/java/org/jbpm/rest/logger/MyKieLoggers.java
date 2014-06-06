package org.jbpm.rest.logger;

import org.drools.core.audit.ThreadedWorkingMemoryFileLogger;
import org.drools.core.audit.WorkingMemoryConsoleLogger;
import org.drools.core.audit.WorkingMemoryFileLogger;
import org.drools.core.impl.AbstractRuntime;
import org.kie.api.event.KieRuntimeEventManager;
import org.kie.api.logger.KieLoggers;
import org.kie.internal.event.KnowledgeRuntimeEventManager;
import org.kie.internal.logger.KnowledgeRuntimeLogger;

public class MyKieLoggers implements KieLoggers {

	public KnowledgeRuntimeLogger newFileLogger(KieRuntimeEventManager session,
			String fileName) {

		WorkingMemoryFileLogger logger = new WorkingMemoryFileLogger(
				(KnowledgeRuntimeEventManager) session);
		if (fileName != null) {
			logger.setFileName(fileName);
		}
		return registerRuntimeLogger(session, new KnowledgeRuntimeFileLoggerWrapper(logger));
	}

	public KnowledgeRuntimeLogger newThreadedFileLogger(
			KieRuntimeEventManager session, String fileName, int interval) {
		ThreadedWorkingMemoryFileLogger logger = new ThreadedWorkingMemoryFileLogger(
				(KnowledgeRuntimeEventManager) session);
		if (fileName != null) {
			logger.setFileName(fileName);
		}
		logger.start(interval);
		return registerRuntimeLogger(session, new KnowledgeRuntimeFileLoggerWrapper(logger));
	}

	public KnowledgeRuntimeLogger newConsoleLogger(
			KieRuntimeEventManager session) {
		WorkingMemoryConsoleLogger logger = new WorkingMemoryConsoleLogger(
				(KnowledgeRuntimeEventManager) session);
		return registerRuntimeLogger(session, new KnowledgeRuntimeConsoleLoggerWrapper(logger));
	}

	private KnowledgeRuntimeLogger registerRuntimeLogger(
			KieRuntimeEventManager session, KnowledgeRuntimeLogger logger) {
		if (session instanceof AbstractRuntime) {
			((AbstractRuntime) session).setLogger(logger);
		}
		return logger;
	}

	private class KnowledgeRuntimeFileLoggerWrapper implements
			KnowledgeRuntimeLogger {

		private WorkingMemoryFileLogger logger;

		public KnowledgeRuntimeFileLoggerWrapper(WorkingMemoryFileLogger logger) {
			this.logger = logger;
		}

		public void close() {
			logger.stop();
		}

	}

	private class KnowledgeRuntimeThreadedFileLoggerWrapper implements
			KnowledgeRuntimeLogger {

		private ThreadedWorkingMemoryFileLogger logger;

		public KnowledgeRuntimeThreadedFileLoggerWrapper(
				ThreadedWorkingMemoryFileLogger logger) {
			this.logger = logger;
		}

		public void close() {
			logger.stop();
		}

	}

	private class KnowledgeRuntimeConsoleLoggerWrapper implements
			KnowledgeRuntimeLogger {

		// private WorkingMemoryConsoleLogger logger;

		public KnowledgeRuntimeConsoleLoggerWrapper(
				WorkingMemoryConsoleLogger logger) {
			// this.logger = logger;
		}

		public void close() {
			// Do nothing
		}

	}

}
