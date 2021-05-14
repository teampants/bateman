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

package org.scalawag.bateman.jsonapi.generic

import org.scalawag.bateman.json.decoding.{DecodeResult, JPointer}
import org.scalawag.bateman.jsonapi
import org.scalawag.bateman.jsonapi.generic.decoding.CaseClassResourceDecoder
import org.scalawag.bateman.jsonapi.generic.encoding.CaseClassResourceEncoder
import org.scalawag.bateman.jsonapi.encoding.{EncodeResult, FieldsSpec, IncludeSpec, ResourceEncoder}

case class CaseClassResourceCodec[
    In <: jsonapi.decoding.ResourceLike,
    CaseClass,
    +Out <: jsonapi.encoding.ResourceLike
](
    encoder: CaseClassResourceEncoder[CaseClass, Out],
    decoder: CaseClassResourceDecoder[In, CaseClass],
) extends CaseClassResourceEncoder[CaseClass, Out]
    with CaseClassResourceDecoder[In, CaseClass] {
  override def resourceType: String = decoder.resourceType
  override def decode(in: In, context: jsonapi.decoding.Document): DecodeResult[CaseClass] = decoder.decode(in, context)

  override def encodeResource(
      in: CaseClass,
      includeSpec: IncludeSpec = IncludeSpec.Opportunistically,
      fieldsSpec: FieldsSpec = FieldsSpec.All
  ): EncodeResult[ResourceEncoder.PartiallyEncoded[Out]] = encoder.encodeResource(in, includeSpec, fieldsSpec)
}
