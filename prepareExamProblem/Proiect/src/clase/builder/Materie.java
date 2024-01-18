package clase.builder;

public class Materie {

	private DenumireMaterie denumireMaterie;
	private NivelDificultate niveldificultate;
	private int semestrul;
	private boolean esteMaterieExtracurriculara;
	private boolean esteMaterieExamenFinal;
	private InterfataContinut continut;

	private Materie() {
	}

	private Materie(DenumireMaterie denumireMaterie) {
		this.denumireMaterie = denumireMaterie;
	}

	public DenumireMaterie getDenumireMaterie() {
		return denumireMaterie;
	}

	public NivelDificultate getNiveldificultate() {
		return niveldificultate;
	}

	public int getSemestrul() {
		return semestrul;
	}

	public boolean isEsteMaterieExtracurriculara() {
		return esteMaterieExtracurriculara;
	}

	public boolean isEsteMaterieExamenFinal() {
		return esteMaterieExamenFinal;
	}

	public InterfataContinut getContinut() {
		return continut;
	}

	private Materie(DenumireMaterie denumireMaterie, NivelDificultate niveldificultate, int semestrul,
			boolean esteMaterieExtracurriculara, boolean esteMaterieExamenFinal, InterfataContinut continut) {
		super();
		this.denumireMaterie = denumireMaterie;
		this.niveldificultate = niveldificultate;
		this.semestrul = semestrul;
		this.esteMaterieExtracurriculara = esteMaterieExtracurriculara;
		this.esteMaterieExamenFinal = esteMaterieExamenFinal;
		this.continut = continut;
	}

	public static class MaterieBuilder {
		Materie materie = null;

		public MaterieBuilder(DenumireMaterie denumireMaterie) {
			materie = new Materie();
			materie.denumireMaterie = denumireMaterie;
		}

		public MaterieBuilder(DenumireMaterie denumireMaterie, NivelDificultate niveldificultate, int semestrul) {
			materie = new Materie();
			materie.denumireMaterie = denumireMaterie;
			materie.niveldificultate = niveldificultate;
			materie.semestrul = semestrul;

		}

		public MaterieBuilder esteMaterieExtracurriculara() {
			this.materie.esteMaterieExtracurriculara = true;
			return this;
		}

		public MaterieBuilder esteMaterieExamenFinal() {
			this.materie.esteMaterieExamenFinal = true;
			return this;
		}

		public MaterieBuilder setContinut(InterfataContinut continut) {
			this.materie.continut = continut;
			return this;
		}

		public Materie build() {
			return materie;
		}

	}

	public String toString() {

		if (esteMaterieExtracurriculara & esteMaterieExamenFinal) {
			return denumireMaterie + " " + niveldificultate + " semestrul " + semestrul
					+ ", este materie extracurriculara" + " si este materie de examen final" + ", " + continut;
		} else if (esteMaterieExtracurriculara & !esteMaterieExamenFinal) {
			return denumireMaterie + " " + niveldificultate + " semestrul " + semestrul
					+ ", este materie extracurriculara" + " si nu este materie de examen final" + ", " + continut;
		} else if (!esteMaterieExtracurriculara & esteMaterieExamenFinal) {
			return denumireMaterie + " " + niveldificultate + " semestrul " + semestrul
					+ ", nu este materie extracurriculara" + " si este materie de examen final" + ", " + continut;
		} else
			return denumireMaterie + " " + niveldificultate + " semestrul " + semestrul
					+ ", nu este materie extracurriculara" + " si nu este materie de examen final" + ", " + continut;
	}

}
