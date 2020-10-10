package seol.commute.service;

public interface CommuteService {

	void process(String[] args) throws Exception;

	void workIn() throws Exception;

	void workOut();

	void generatePassword(String dec);

}
