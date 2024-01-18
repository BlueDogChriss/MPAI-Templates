package clase.visitor;

import java.util.List;

public class MessagingVisitor implements Visitor {
	
	public void sendMessages(List<Persoana> persoane) {
		for(Persoana persoana : persoane) {
			persoana.accept(this);
		}
	}

	@Override
	public void visitProfesorScoala() {
		System.out.println("S-a programat o meditatie cu un elev de scoala");
	}

	@Override
	public void visitProfesorLiceu() {
		System.out.println("S-a programat o meditatie cu un elev de liceu");
	}

	@Override
	public void visitElevScoala() {
		System.out.println("S-a programat o meditatie cu un profesor de scoala");
	}

	@Override
	public void visitElevLiceu() {
		System.out.println("S-a programat o meditatie cu un profesor de liceu");
	}

}
