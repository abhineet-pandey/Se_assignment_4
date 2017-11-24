package model;

public class NuQuestions {
	public static int qno;
	public static String question;
	public static String answer;
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
	public int getqno() {
	return qno;	
	}
	public void setqno(int qno) {
		this.qno = qno;
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
