package com.valtech.training.mobile.ranking;

import java.util.List;

import com.valtech.training.patternchecker.PatternCheckerService;

public class MobileRankingServiceImpl implements MobileRankingService{

	private PatternCheckerService patternCheckerService;
	@Override
	public int rankMobile(List<String> mobile) {
		List<String> patterns = patternCheckerService.listPatterns(mobile);
		return 0;
	}

}
