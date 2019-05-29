package com.StackOverFlow;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ForloopToStream {

	final ZonedDateTime from;
	final ZonedDateTime to;

	ForloopToStream(ZonedDateTime zonedDateTime, ZonedDateTime i) {
		this.from = zonedDateTime;
		this.to = i;
	}

	@Override
	public String toString() {
		return "DateBlock {" + this.from.toString() + " : " + this.to.toString() + "}";
	}

	public static List<ForloopToStream> blockize(ZonedDateTime fromDate, ZonedDateTime toDate, int blockSize,
			ChronoUnit blockSizeUnit) {
		List<ForloopToStream> blocks = new ArrayList<>();
		boolean reachedDate = false;
		for (int i = 0; !reachedDate; i++) {
			ZonedDateTime minDate = fromDate.plus(i * blockSize, blockSizeUnit);
			ZonedDateTime maxDate = fromDate.plus((i + 1) * blockSize, blockSizeUnit);
			reachedDate = toDate.isBefore(maxDate);
			blocks.add(new ForloopToStream(minDate, maxDate));
		}

		
		
		return blocks;
	}

	public static void main(String[] args) {
		ZonedDateTime start = ZonedDateTime.now();
		ZonedDateTime end = ZonedDateTime.now().plusDays(5);
		Predicate<ZonedDateTime> beforeEnd = date -> date.isBefore(end);
		final int blockSize = 1;
		List<ForloopToStream> blocks = new ArrayList<>();

		Stream.iterate(start, d -> d.plus(blockSize, ChronoUnit.DAYS)).map(d -> d.plus(1, ChronoUnit.DAYS)).peek(i -> {
			if (beforeEnd.test(i))
				blocks.add(new ForloopToStream(i.minus(1, ChronoUnit.DAYS), i));
		}).allMatch(beforeEnd);
		System.out.println(blocks);
		// blockize(start, end, blockSize, ChronoUnit.HALF_DAYS);
	}
}
