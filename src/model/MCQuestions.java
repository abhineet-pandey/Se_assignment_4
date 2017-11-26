package model;

public class MCQuestions {
	private static int qnomcq;
	public static String question;
	public static String answer;
	public static String choiceA;
	public static String choiceB;
	public static String choiceC;
	public static String choiceD;
	public static String hint1;
	public static String hint2;
	public static String hint3;
	public static String feedback;
	public static int hint_state;
	
	public int gethint_state() {
		return hint_state;	
		}
		public void sethint_state(int hint_state) {
			this.hint_state = hint_state;
		}
	public int getqnomcq() {
		return qnomcq;	
		}
		public void setqnomcq(int qnomcq) {
			this.qnomcq = qnomcq;
		}

	public String getquestion() {
		return question;
	}
	public  void setquestion(String question) {
		this.question = question;
	}
	
	public String getanswer() {
		return answer;
	}
	public void setanswer(String answer) {

		this.answer = answer;
	}
	
	public String getfeedback() {
		return feedback;
	}
	public void setfeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setchoiceA(String choiceA) {
		this.choiceA = choiceA;
	}
	public String getchoiceA() {
		return choiceA;
	}

	public void setchoiceB(String choiceB) {
		this.choiceB = choiceB;
	}
	public String getchoiceB() {
		return choiceB;
	}

	public void setchoiceC(String choiceC) {
		this.choiceC = choiceC;
	}
	public String getchoiceC() {
		return choiceC;
	}

	public void setchoiceD(String choiceD) {
		this.choiceD = choiceD;
	}
	public String getchoiceD() {
		return choiceD;
	}

	public void sethint1(String hint1) {
		this.hint1 = hint1;
	}
	public String gethint1() {
		return hint1;
	}

	public void sethint2(String hint2) {
		this.hint2 = hint2;
	}
	public String gethint2() {
		return hint2;
	}

	public void sethint3(String hint3) {
		this.hint3 = hint3;
	}
	public String gethint3() {
		return hint3;
	}
}
