public class Vector2D {
	int listSize;
	int levelSize;
	int levelp = 0;
	int listp = 0;
	List<List<Integer>> vec;

	public Vector2D(List<List<Integer>> vec2d) {
        	levelSize = vec2d.size();
		vec = new List<ArrayList<Integer>>();
		for (List<Integer> list : vec2d) {
			vec.add(new ArrayList<Integer>(list));
		}
	}

	public int next() {
		if (levelp < levelSize && listp < listSize) {
			int ret = vec.get(levelp).get(listp);
			if (listp < listSize - 1) { // not last element in the list
				listp++;
			} else { // last element in the list
				levelp++;
				listp = 0;
				listSize = vec.get(levelp).size();
			}
			return ret; 
		}
        	return -1;
	}

	public boolean hasNext() {
		if (levelSize == 0 || levelp >= levelSize) {
			return false;
		}
		if ((listp < listSize - 1) || (listp == listSize - 1
		    && levelp < levelSize - 1 
		    && vec.get(levelp + 1).size() > 0)) {
			return true;
		}
        	return false;
	}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
