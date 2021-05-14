// bateman -- Copyright 2021 -- Justin Patterson
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.scalawag.bateman.json.decoding.parser.eventizer

import org.scalawag.bateman.json.decoding.parser.tokenizer.{
  CloseBrace,
  CloseBracket,
  OpenBrace,
  OpenBracket,
  PrimitiveToken,
  StringToken
}

sealed trait Event

final case class ObjectStart(token: OpenBrace) extends Event
final case class ObjectEnd(token: CloseBrace) extends Event

final case class FieldStart(name: StringToken) extends Event
case object FieldEnd extends Event

final case class ArrayStart(token: OpenBracket) extends Event
final case class ArrayEnd(token: CloseBracket) extends Event

final case class IndexStart(index: Int) extends Event
final case class IndexEnd() extends Event

final case class Value(token: PrimitiveToken) extends Event
