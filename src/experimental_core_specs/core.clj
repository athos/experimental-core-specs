(ns experimental-core-specs.core
  (:require [clojure.spec.alpha :as s]))

(defmacro define-simple-predicate-specs [& preds]
  `(do ~@(for [pred preds]
           `(s/fdef ~pred :args (s/cat :x any?) :ret boolean?))))

(define-simple-predicate-specs
  any?
  nil?
  false?
  true?
  boolean?
  symbol?
  simple-symbol?
  qualified-symbol?
  special-symbol?
  keyword?
  simple-keyword?
  qualified-keyword?
  ident?
  simple-ident?
  qualified-ident?
  number?
  rational?
  integer?
  int?
  nat-int?
  pos-int?
  neg-int?
  decimal?
  double?
  float?
  bigdec?
  ratio?
  char?
  string?
  coll?
  seq?
  seqable?
  list?
  set?
  vector?
  map?
  map-entry?
  ifn?
  fn?
  var?
  class?
  record?
  bytes?
  inst?
  uuid?
  uri?
  volatile?
  future?
  delay?
  reduced?
  tagged-literal?
  reader-conditional?
  )

(s/fdef = :args (s/+ any?) :ret boolean?)
(s/fdef not= :args (s/+ any?) :ret boolean?)
(s/fdef identical? (s/cat :x any? :y any?) boolean?)

(s/fdef zero? :args (s/cat :num number?) :ret boolean?)
(s/fdef pos? :args (s/cat :num number?) :ret boolean?)
(s/fdef neg? :args (s/cat :num number?) :ret boolean?)
(s/fdef even? :args (s/cat :n integer?) :ret boolean?)
(s/fdef odd? :args (s/cat :n integer?) :ret boolean?)

(s/fdef + :args (s/* number?) :ret number?)
(s/fdef - :args (s/+ number?) :ret number?)
(s/fdef * :args (s/* number?) :ret number?)
(s/fdef / :args (s/+ number?) :ret number?)
(s/fdef < :args (s/+ number?) :ret boolean?)
(s/fdef > :args (s/+ number?) :ret boolean?)
(s/fdef <= :args (s/+ number?) :ret boolean?)
(s/fdef >= :args (s/+ number?) :ret boolean?)
(s/fdef == :args (s/+ number?) :ret boolean?)

(s/fdef num :args (s/cat :x number?) :ret number?)
(s/fdef byte :args (s/cat :x number?) :ret int?)
(s/fdef short :args (s/cat :x number?) :ret int?)
(s/fdef int :args (s/cat :x number?) :ret int?)
(s/fdef long :args (s/cat :x number?) :ret int?)
(s/fdef bigint :args (s/cat :x number?) :ret integer?)
(s/fdef biginteger :args (s/cat :x number?) :ret integer?)
(s/fdef float :args (s/cat :x number?) :ret float?)
(s/fdef double :args (s/cat :x number?) :ret double?)
(s/fdef bigdec :args (s/cat :x number?) :ret bigdec?)

(s/fdef inc :args (s/cat :x number?) :ret number?)
(s/fdef dec :args (s/cat :x number?) :ret number?)
(s/fdef quot :args (s/cat :num number? :div number?) :ret number?)
(s/fdef mod :args (s/cat :num number? :div number?) :ret number?)
(s/fdef rem :args (s/cat :num number? :div number?) :ret number?)
(s/fdef max :args (s/+ number?) :ret number?)
(s/fdef min :args (s/+ number?) :ret number?)

(s/fdef +' :args (s/* number?) :ret number?)
(s/fdef -' :args (s/+ number?) :ret number?)
(s/fdef *' :args (s/* number?) :ret number?)
(s/fdef inc' :args (s/cat :x number?) :ret number?)
(s/fdef dec' :args (s/cat :x number?) :ret number?)

(s/fdef unchecked-char :args (s/cat :x number?) :ret char?)
(s/fdef unchecked-byte :args (s/cat :x number?) :ret int?)
(s/fdef unchecked-short :args (s/cat :x number?) :ret int?)
(s/fdef unchecked-int :args (s/cat :x number?) :ret int?)
(s/fdef unchecked-long :args (s/cat :x number?) :ret int?)
(s/fdef unchecked-float :args (s/cat :x number?) :ret float?)
(s/fdef unchecked-double :args (s/cat :x number?) :ret double?)
(s/fdef unchecked-add :args (s/cat :x number? :y number?) :ret number?)
(s/fdef unchecked-subtract :args (s/cat :x number? :y number?) :ret number?)
(s/fdef unchecked-multiply :args (s/cat :x number? :y number?) :ret number?)
(s/fdef unchecked-negate :args (s/cat :x number?) :ret number?)
(s/fdef unchecked-inc :args (s/cat :x number?) :ret number?)
(s/fdef unchecked-dec :args (s/cat :x number?) :ret number?)
(s/fdef unchecked-add-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef unchecked-subtract-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef unchecked-multiply-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef unchecked-divide-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef unchecked-remainder-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef unchecked-negate-int :args (s/cat :x number?) :ret int?)
(s/fdef unchecked-inc-int :args (s/cat :x number?) :ret int?)
(s/fdef unchecked-dec-int :args (s/cat :x number?) :ret int?)

(s/fdef bit-not :args (s/cat :x int?) :ret int?)
(s/fdef bit-and :args (s/cat :x int? :y int? :more (s/* int?)) :ret int?)
(s/fdef bit-or :args (s/cat :x int? :y int? :more (s/* int?)) :ret int?)
(s/fdef bit-xor :args (s/cat :x int? :y int? :more (s/* int?) :ret int?))
(s/fdef bit-and-not :args (s/cat :x int? :y int? :more (s/* int?)) :ret int?)
(s/fdef bit-shift-left :args (s/cat :x int? :n int?) :ret int?)
(s/fdef bit-shift-right :args (s/cat :x int? :n int?) :ret int?)
(s/fdef unsigned-bit-shift-right :args (s/cat :x int? :n int?) :ret int?)
(s/fdef bit-test :args (s/cat :x int? :n int?) :ret boolean?)
(s/fdef bit-clear :args (s/cat :x int? :n int?) :ret int?)
(s/fdef bit-set :args (s/cat :x int? :n int?) :ret int?)
(s/fdef bit-flip :args (s/cat :x int? :n int?) :ret int?)

(s/fdef rationalize :args (s/cat :num number?) :ret rational?)
(s/fdef numerator :args (s/cat :r ratio?) :ret integer?)
(s/fdef denominator :args (s/cat :r ratio?) :ret integer?)
(s/fdef rand :args (s/? number?) :ret number?)
(s/fdef rand-int :args (s/cat :n int?) :ret int?)

(s/fdef empty? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef sequential? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef associative? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef indexed? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef counted? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef sorted? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef reversible? :args (s/cat :coll coll?) :ret boolean?)

(s/fdef chunked-seq? :args (s/cat :s seq?) :ret boolean?)

(comment

bound?
restart-agent
sort-by
macroexpand
ensure
chunk-first
eduction
tree-seq
seq
reduce
find-ns
get-thread-bindings
contains?
every?
proxy-mappings
keep-indexed
subs
ref-min-history
set
take-last
reader-conditional
->Eduction
butlast
satisfies?
line-seq
take-nth
first
re-groups
ns-unmap
println-str
with-bindings*
inst-ms
iterator-seq
iterate
slurp
newline
short-array
doall
prefers
enumeration-seq
dedupe
dissoc
atom
print-method
peek
aget
last
pr
namespace
push-thread-bindings
bases
remove-ns
take
thread-bound?
send-via
boolean
find-var
aclone
vreset!
chunk
future-call
resultset-seq
struct
map
juxt
ns-publics
test
rest
ex-data
compile
isa?
munge
set-error-mode!
re-seq
make-hierarchy
set-agent-send-executor!
swap-vals!
keep
char
mapcat
aset-long
some?
reverse
range
sort
map-indexed
rand-nth
comp
await
spit
future-done?
dorun
disj
eval
cons
refer
print-dup
floats
fnil
merge-with
nthrest
load
shuffle
boolean-array
find
alength
deliver
var-set
pmap
error-mode
disj!
aset-float
bean
booleans
ns-unalias
int-array
cat
StackTraceElement->vec
flush
take-while
vary-meta
alter
conj!
repeatedly
zipmap
reset-vals!
alter-var-root
remove
re-pattern
pop!
chunk-append
prn-str
format
shutdown-agents
conj
transduce
compare-and-set!
await1
ref-set
pop-thread-bindings
interleave
printf
get
identity
into
nfirst
meta
find-protocol-impl
method-sig
hash-ordered-coll
reset-meta!
cycle
seque
filterv
hash
ns-aliases
read
key
longs
aset-double
chunk-rest
pcalls
remove-all-methods
ns-resolve
aset-boolean
trampoline
vec
ns-refers
second
vector-of
hash-combine
replace
set-error-handler!
inst-ms*
force
bound-fn*
namespace-munge
group-by
prn
extend
->VecSeq
Inst
double-array
in-ns
create-ns
re-matcher
ref
extends?
promise
aset-char
rseq
construct-proxy
agent-errors
pr-str
concat
aset-short
set-agent-send-off-executor!
symbol
to-array-2d
pop
use
dissoc!
reductions
aset-byte
ref-history-count
assoc!
hash-set
reduce-kv
cast
reset!
name
ffirst
sorted-set
byte-array
tagged-literal
println
macroexpand-1
assoc-in
char-name-string
memoize
alter-meta!
require
persistent!
nnext
add-watch
not-every?
agent-error
some
future-cancelled?
struct-map
drop
nth
split-at
load-reader
random-sample
select-keys
bounded-count
update
list*
update-in
prefer-method
aset-int
ensure-reduced
instance?
mix-collection-hash
re-find
run!
val
loaded-libs
->Vec
not
with-meta
unreduced
the-ns
type
ns-name
max-key
file-seq
agent
ns-map
set-validator!
swap!
vals
sorted-set-by
release-pending-sends
print
empty
remove-method
print-ctor
volatile!
read-line
clear-agent-errors
vector
drop-last
not-empty
distinct
partition
add-classpath
long-array
descendants
merge
accessor
mapv
partition-all
partition-by
object-array
derive
load-string
ancestors
subseq
error-handler
gensym
intern
print-simple
flatten
doubles
halt-when
remove-watch
ex-info
proxy-name
ns-interns
all-ns
find-protocol-method
subvec
partial
find-keyword
replicate
min-key
reduced
char-escape-string
re-matches
array-map
ns-imports
send-off
every-pred
keys
load-file
distinct?
extenders
methods
->ArrayChunk
float-array
alias
frequencies
read-string
rsubseq
get-method
filter
list
split-with
aset
->VecNode
keyword
destructure
chars
str
next
hash-map
underive
ref-max-history
Throwable->map
ints
class
some-fn
to-array
xml-seq
parents
count
supers
sorted-map-by
apply
interpose
deref
assoc
transient
clojure-version
chunk-cons
comparator
sorted-map
send
drop-while
proxy-call-with-super
realized?
char-array
resolve
compare
complement
with-redefs-fn
sequence
constantly
get-proxy-class
make-array
shorts
completing
update-proxy
hash-unordered-coll
repeat
nthnext
create-struct
get-validator
await-for
chunk-next
print-str
not-any?
into-array
init-proxy
chunk-buffer
future-cancel
var-get
commute
get-in
fnext
bytes

when-first
cond->>
while
import
bound-fn
dosync
with-loading-context
..
delay
with-bindings
if-not
doseq
deftype
when-let
if-some
with-precision
lazy-seq
let
->
defstruct
doto
areduce
definline
future
fn
definterface
as->
when-not
when
some->>
defn
ns
amap
declare
or
extend-type
defmethod
time
memfn
extend-protocol
cond->
dotimes
reify
with-open
defonce
defn-
defprotocol
sync
assert
letfn
proxy-super
loop
with-out-str
condp
cond
with-in-str
some->
for
binding
with-local-vars
defmacro
proxy
with-redefs
locking
defmulti
if-let
case
io!
lazy-cat
comment
defrecord
and
when-some
->>
gen-class
gen-interface
pvalues
vswap!
refer-clojure

)
