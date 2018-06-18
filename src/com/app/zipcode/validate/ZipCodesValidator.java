package com.app.zipcode.validate;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.app.zipcode.validate.utils.Interval;

public class ZipCodesValidator {

	public Stack<Interval> getMinRestrictionRanges(List<Interval> allCodes) {
		Stack<Interval> minRange = new Stack<>();

		// sort by start dates
		Collections.sort(allCodes, (i1, i2) -> i1.getStart() - i2.getStart());

		// merge intervals
		for (Interval interval : allCodes) {
			if (minRange.isEmpty()) {
				minRange.add(interval);
			} else {
				if (minRange.peek().getEnd() < interval.getStart()) {
					minRange.add(interval);
				} else if (minRange.peek().getEnd() < interval.getEnd()) {
					Interval modifiedLastInterval = minRange.pop();
					modifiedLastInterval.setEnd(interval.getEnd());
					minRange.add(modifiedLastInterval);
				}
			}
		}

		// return stack in ascending order
		Stack<Interval> sortedMinRange = new Stack<>();

		while (!minRange.isEmpty()) {
			sortedMinRange.add(minRange.pop());
		}

		return sortedMinRange;
	}

}
