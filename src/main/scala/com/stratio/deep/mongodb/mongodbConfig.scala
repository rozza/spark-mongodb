/*
 *  Licensed to STRATIO (C) under one or more contributor license agreements.
 *  See the NOTICE file distributed with this work for additional information
 *  regarding copyright ownership. The STRATIO (C) licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package com.stratio.deep.mongodb

import com.mongodb
import com.mongodb.MongoCredential
import com.stratio.deep.DeepConfig._
import com.stratio.deep.DeepConfigBuilder
import com.stratio.deep.mongodb.MongodbConfig._

/**
 * Created by jsantos on 5/02/15.
 *
 * A specialized deep configuration builder.
 * It focuses on mongodb config parameters
 * such as host,database,collection, samplingRatio (for schema infer)
 * @param props Initial properties map
 */
case class MongodbConfigBuilder(
  props: Map[Property, Any] = Defaults
) extends {
  override val properties = Defaults ++ props
} with DeepConfigBuilder[MongodbConfigBuilder](properties) {

  val requiredProperties: List[Property] = MongodbConfig.all

  def apply(props: Map[Property, Any]) =
    MongodbConfigBuilder(props)
}

object MongodbConfig {

  //  Parameter names

  val Host = "host"
  val Database = "database"
  val Collection = "collection"
  val SamplingRatio = "schema_samplingRatio"
  val WriteConcern = "writeConcern"
  val SplitSize = "splitSize"
  val SplitKey = "splitKey"
  val AllowSlaveReads = "allowSlaveReads"
  val Credentials = "credentials"
  val PrimaryKey = "primaryKey"

  val all = List(
    Host,
    Database,
    Collection,
    SamplingRatio,
    WriteConcern,
    SplitKey,
    SplitSize)

  //  Default values

  val DefaultSamplingRatio = 1.0
  val DefaultWriteConcern = mongodb.WriteConcern.ACKNOWLEDGED
  val DefaultSplitKey = "_id"
  val DefaultSplitSize = 10
  val DefaultAllowSlaveReads = false
  val DefaultCredentials = List[MongoCredential]()

  val Defaults = Map(
    SamplingRatio -> DefaultSamplingRatio,
    WriteConcern -> DefaultWriteConcern,
    SplitKey -> DefaultSplitKey,
    SplitSize -> DefaultSplitSize,
    AllowSlaveReads -> DefaultAllowSlaveReads,
    Credentials -> DefaultCredentials)

}
