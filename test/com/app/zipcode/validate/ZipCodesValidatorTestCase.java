package com.app.zipcode.validate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import com.app.zipcode.validate.utils.Interval;

public class ZipCodesValidatorTestCase {

	private ZipCodesValidator validator;

	@Before
	public void setUp() throws Exception {
		validator = new ZipCodesValidator();
	}

	@Test
	public void getMinRestrictionRanges() {
		// If the input = [94133,94133] [94200,94299] [94226,94399]
		// Then the output should be = [94133,94133] [94200,94399]

		List<Interval> allZipCodes = new ArrayList<>();
		allZipCodes.add(new Interval(94133, 94133));
		allZipCodes.add(new Interval(94200, 94299));
		allZipCodes.add(new Interval(94226, 94399));
		Stack<Interval> minZipCodes = validator.getMinRestrictionRanges(allZipCodes);

		Interval i = minZipCodes.pop();

		assertTrue(i.getStart() == 94133);
		i = minZipCodes.pop();
		assertTrue(i.getStart() == 94200);
		assertTrue(minZipCodes.isEmpty());

	}

	@Test
	public void getMinRestrictionRanges_Empty() {
		// empty test
	}

	@Test
	public void getMinRestrictionRanges_SingleInterval() {
		// Single Zip code test
	}

	@Test
	public void getMinRestrictionRanges_OverlappingIntervals() {
		// some overlapping Zip Code test
	}

	@Test
	public void getMinRestrictionRanges_NonOverLappingIntervals() {
		// Non overlapping Zip codes test
	}

}
