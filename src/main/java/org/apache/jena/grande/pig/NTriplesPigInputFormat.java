/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.grande.pig;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.jena.grande.mapreduce.io.TripleRecordReader;
import org.apache.jena.grande.mapreduce.io.TripleWritable;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.PigFileInputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTriplesPigInputFormat extends PigFileInputFormat<LongWritable, TripleWritable> {

	private static final Logger log = LoggerFactory.getLogger(NTriplesPigInputFormat.class);

	@Override
	public RecordReader<LongWritable, TripleWritable> createRecordReader(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
		RecordReader<LongWritable, TripleWritable> recordReader = new TripleRecordReader();
		log.debug("createRecordReader({},{}) --> {}", new Object[]{split,context,recordReader});
		return recordReader;
	}

}
