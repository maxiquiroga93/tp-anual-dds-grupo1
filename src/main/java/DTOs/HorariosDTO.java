package DTOs;

public class HorariosDTO {
	int diaSemana;
	int horaDesde;
	int minutosDesde;
	int horaHasta;
	int minHasta;

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(int horaDesde) {
		this.horaDesde = horaDesde;
	}

	public int getMinutosDesde() {
		return minutosDesde;
	}

	public void setMinutosDesde(int minutosDesde) {
		this.minutosDesde = minutosDesde;
	}

	public int getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(int horaHasta) {
		this.horaHasta = horaHasta;
	}

	public int getMinHasta() {
		return minHasta;
	}

	public void setMinHasta(int minHasta) {
		this.minHasta = minHasta;
	}

}
