package de.slashgarbage.example;

public class FrameFactory {

	public static Frame createFrame(String grameFrame, int index) throws Exception {
		if (grameFrame.length() == 1) {
			if (grameFrame.charAt(0) == 'X') {				
				return new StrikeFrame();
			}
			throw new IllegalArgumentException("'X' is only valid symbol for STRIKE.");
		}
		if(grameFrame.matches("[0-9]{2}")){
			
			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			if(firstBalls + secondBalls > 10) {
				throw new IllegalArgumentException("maximum number of pin is 10.");
			}
			if(index == 9) return new LastFrame( firstBalls, secondBalls, 0);
			return new SimpleFrame( firstBalls, secondBalls);
		}
		if(grameFrame.matches("[0-9]{1}/")){			
			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			return new SpareFrame( firstBalls);
		}
		if(grameFrame.matches("[0-9]{1}XX")){			
			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			return new LastFrame( firstBalls, 10,10);
		}
		if(grameFrame.matches("X[0-9]{2}")){			
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			int thirdBalls = Integer.parseInt("" + grameFrame.charAt(2));
			if(secondBalls + thirdBalls > 10) {
				throw new IllegalArgumentException("maximum number of pin is 10.");
			}
			return new LastFrame( 10, secondBalls,thirdBalls);
		}
		if(grameFrame.matches("XX[0-9]{1}")){			
			int thirdBalls = Integer.parseInt("" + grameFrame.charAt(2));
			return new LastFrame( 10, 10,thirdBalls);
		}
		if(grameFrame.matches("X[0-9]{1}/")){			
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			return new LastFrame( 10, secondBalls,10-secondBalls);
		}
		if(grameFrame.matches("XXX")){			
			return new LastFrame( 10, 10,10);
		}
		if(grameFrame.matches("X[0-9]{1}/")){			
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			return new LastFrame( 10, secondBalls,10-secondBalls);
		}
		if(grameFrame.matches("X0X")){			
			int secondBalls = Integer.parseInt("" + grameFrame.charAt(1));
			return new LastFrame( 10, secondBalls,10-secondBalls);
		}
		if(grameFrame.matches("[0-9]{1}/[0-9]{1}")){			
			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			int thirdBalls = Integer.parseInt("" + grameFrame.charAt(2));
			return new LastFrame( firstBalls, 10-firstBalls, thirdBalls);
		}
		if(grameFrame.matches("[0-9]{1}/X")){			
			int firstBalls = Integer.parseInt("" + grameFrame.charAt(0));
			return new LastFrame( firstBalls, 10-firstBalls,10);
		}
		throw new IllegalArgumentException("invalid chars");
	}

	public static Frame createFrame(String grameFrame) throws Exception {
		return createFrame(grameFrame, -1);
	}

}
