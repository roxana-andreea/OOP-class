package liceu;

import java.util.Map;

/**
 * 
 * @author Roxana Cazacu
 * @grupa 324CC
 * 
 */
public interface IElev {

	public String getDataNasterii();

	
	/**
	 * Intoarce situatia scolara a elevului
	 * @return
	 */
	public Map<Materie, SituatieMaterieBaza> situatieScolara();
}
