package DAY4;

public class MusicSystem {
	
	private int musicSound;
	
	public MusicSystem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MusicSystem(int musicSound) {
		this.musicSound=musicSound;
	}

	public int getMusicSound() {
		return musicSound;
	}


	public void setMusicSound(int musicSound) {
		this.musicSound = musicSound;
	}
	
	public int checkMusicSound(String sound) {
		if(sound.equals("Bass")) {
			return musicSound*5;
		}
		else if(sound.equals("Flat")) {
			return musicSound;
		}else if(sound.equals("Speech")) {
			return musicSound*2;
		}
		else {
			return musicSound*3;
		}
		
	}

		

}
