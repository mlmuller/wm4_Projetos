package br.com.gvdexport.dao;

import java.util.Comparator;

import br.com.gvdexport.model.CorAmostraMulti;

public class SortPorCorComplemento implements Comparator<CorAmostraMulti> {

	
		@Override
		public int compare(CorAmostraMulti o1, CorAmostraMulti o2) {
			Integer comparacao = 0;
			comparacao = o1.getSeqCor().compareTo(o2.getSeqCor());
			if (comparacao == 0) {
				comparacao = o1.getCompletaCor().compareTo(o2.getCompletaCor());
			}
			return comparacao;
		}
    }
	
	
