type ConsoleColor =
	| 'reset'
	| 'red'
	| 'green'
	| 'yellow'
	| 'blue'
	| 'magenta'
	| 'cyan'
	| 'white';

/**
 * Logger Util
 * @param message - message
 * @param color - color
 */
const logMessage = (message: string, color: ConsoleColor = 'reset'): void => {
	const colors: Record<ConsoleColor, string> = {
		reset: '\x1b[0m',
		red: '\x1b[31m',
		green: '\x1b[32m',
		yellow: '\x1b[33m',
		blue: '\x1b[34m',
		magenta: '\x1b[35m',
		cyan: '\x1b[36m',
		white: '\x1b[37m',
	};

	const chosenColor = colors[color];
	console.log(`${chosenColor}%s\x1b[0m`, message);
};

/**
 * Logger Utility
 */
export const logger = {
	info: (message: string) => logMessage('\n==> ' + message, 'cyan'),
	warn: (message: string) => logMessage('⚠️ ' + message, 'yellow'),
	error: (message: string) => logMessage('🔴' + message, 'red'),
	success: (message: string) => logMessage('✅ ' + message, 'green'),
	log: (message: string, color: ConsoleColor = 'reset') =>
		logMessage('🚀 ' + message, color),
};
