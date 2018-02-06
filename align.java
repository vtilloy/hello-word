	private void align() throws CompoundNotFoundException {

		String targetSeq = GeneReference.getRefSequence();
		DNASequence target = new DNASequence(targetSeq, AmbiguityDNACompoundSet.getDNACompoundSet());
		System.out.println(targetSeq);
		String querySeq = FastaSequence.getSequence();
//		String querySeq = this.fastaSequence.getSequence();
		DNASequence query = new DNASequence(querySeq, AmbiguityDNACompoundSet.getDNACompoundSet());
		System.out.println(querySeq);

		SubstitutionMatrix<NucleotideCompound> matrix = SubstitutionMatrixHelper.getNuc4_4();

		SimpleGapPenalty gapP = new SimpleGapPenalty();
		gapP.setOpenPenalty((short)5);
		gapP.setExtensionPenalty((short)2);

		SequencePair<DNASequence, NucleotideCompound> psa = Alignments.getPairwiseAlignment(query, target, PairwiseSequenceAlignerType.GLOBAL, gapP, matrix);


		this.RsltTa.setText(psa.toString());
		this.RsltTa.getStyleClass().add("monospace");
		this.container.setSpacing(10);
	}