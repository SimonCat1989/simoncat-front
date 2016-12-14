package com.simoncat.front.pathfinder;

import java.util.List;

import com.simoncat.front.graph.GraphOld;
import com.simoncat.front.model.Path;
import com.simoncat.front.model.Site;

public interface PathFinder {

	List<Path> getPath(GraphOld cableTopology, Site start, Site destination);
}
