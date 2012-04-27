package jet.hipics21.business.rules.dressage;


public enum DRESSAGE_PROGRAM {

	FB01, FB02, FB03, FB04, FB05, FB05DR, FB06, FB07, FB08, FB09, FB10, 
	FBQuadrillePasDeDeux, FBKUR,
	JC01, JC02, JC03, JC04, JC05, JC06,
	L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, LKUR,
	M21, M22, M23, M24, M25, M26, M27, M28, M29,MKUR,
	S31, S32, 
	FEIGP, FEIGPYR, FEIGPKUR, FEIGPS, 
	FEIINTER1, FEIINTER2, FEIINTER1KUR,
	FEISTGEORGES, FEISTGEORGESKUR,
	CCB1A, CCB1B, CCB2A, CCB2B, CCB3A, CCB3B, 
	CIC1A, CIC1B, CIC2A, CIC2B, CIC3A, CIC3B, CIC4A, CIC4B,
	PASDEDEUX,
	LIBRE_A_LA_CARTE;
	
	private DressageTestDetails dressageTestDetails = null;

	public DressageTestDetails getDressageTestDetails() {
		return this.dressageTestDetails;
	}

	public void setDressageTestDetails(DressageTestDetails dressageTestDetails) {
		this.dressageTestDetails = dressageTestDetails;
	}
	
	
}
