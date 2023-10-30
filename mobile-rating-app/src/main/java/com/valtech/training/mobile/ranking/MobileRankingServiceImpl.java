package com.valtech.training.mobile.ranking;
import java.util.List;


public class MobileRankingServiceImpl implements MobileRankingService{

	private PatternCheckService patternCheckerService;
	@Override
	public int rankMobile(List<String> patterns) {
		List<String> patterns = patternCheckerService.ListPatterns(mobile);
		return 0;
	}

}
