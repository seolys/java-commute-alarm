package seol.commute.service;

public interface SlackService {

	void sendWorkoutMessage();

	void sendMessage(String message);
}
