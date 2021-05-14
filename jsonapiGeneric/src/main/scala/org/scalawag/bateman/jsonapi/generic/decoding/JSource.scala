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

package org.scalawag.bateman.jsonapi.generic.decoding

import org.scalawag.bateman.json.decoding.{JObject, JPointer}
import org.scalawag.bateman.json.generic.decoding.JSourceLike
import org.scalawag.bateman.jsonapi.decoding.ResourceLike

final case class JSource(resource: ResourceLike, root: JObject, fields: Map[String, JPointer] = Map.empty)
    extends JSourceLike
