(ns experimental-core-specs.core
  (:require [clojure.core :as c]
            [clojure.spec.alpha :as s]))

(defmacro define-simple-predicate-specs [& preds]
  `(do ~@(for [pred preds]
           `(s/fdef ~pred :args (s/cat :x any?) :ret boolean?))))

(define-simple-predicate-specs
  c/any?
  c/nil?
  c/false?
  c/true?
  c/boolean?
  c/symbol?
  c/simple-symbol?
  c/qualified-symbol?
  c/special-symbol?
  c/keyword?
  c/simple-keyword?
  c/qualified-keyword?
  c/ident?
  c/simple-ident?
  c/qualified-ident?
  c/number?
  c/rational?
  c/integer?
  c/int?
  c/nat-int?
  c/pos-int?
  c/neg-int?
  c/decimal?
  c/double?
  c/float?
  c/bigdec?
  c/ratio?
  c/char?
  c/string?
  c/coll?
  c/seq?
  c/seqable?
  c/list?
  c/set?
  c/vector?
  c/map?
  c/map-entry?
  c/ifn?
  c/fn?
  c/var?
  c/class?
  c/record?
  c/bytes?
  c/inst?
  c/uuid?
  c/uri?
  c/volatile?
  c/future?
  c/delay?
  c/reduced?
  c/tagged-literal?
  c/reader-conditional?
  )

(s/fdef c/= :args (s/+ any?) :ret boolean?)
(s/fdef c/not= :args (s/+ any?) :ret boolean?)
(s/fdef c/identical? (s/cat :x any? :y any?) boolean?)

(s/fdef c/zero? :args (s/cat :num number?) :ret boolean?)
(s/fdef c/pos? :args (s/cat :num number?) :ret boolean?)
(s/fdef c/neg? :args (s/cat :num number?) :ret boolean?)
(s/fdef c/even? :args (s/cat :n integer?) :ret boolean?)
(s/fdef c/odd? :args (s/cat :n integer?) :ret boolean?)

(s/fdef c/+ :args (s/* number?) :ret number?)
(s/fdef c/- :args (s/+ number?) :ret number?)
(s/fdef c/* :args (s/* number?) :ret number?)
(s/fdef c// :args (s/+ number?) :ret number?)
(s/fdef c/< :args (s/+ number?) :ret boolean?)
(s/fdef c/> :args (s/+ number?) :ret boolean?)
(s/fdef c/<= :args (s/+ number?) :ret boolean?)
(s/fdef c/>= :args (s/+ number?) :ret boolean?)
(s/fdef c/== :args (s/+ number?) :ret boolean?)

(s/fdef c/num :args (s/cat :x number?) :ret number?)
(s/fdef c/byte :args (s/cat :x number?) :ret int?)
(s/fdef c/short :args (s/cat :x number?) :ret int?)
(s/fdef c/int :args (s/cat :x number?) :ret int?)
(s/fdef c/long :args (s/cat :x number?) :ret int?)
(s/fdef c/bigint :args (s/cat :x number?) :ret integer?)
(s/fdef c/biginteger :args (s/cat :x number?) :ret integer?)
(s/fdef c/float :args (s/cat :x number?) :ret float?)
(s/fdef c/double :args (s/cat :x number?) :ret double?)
(s/fdef c/bigdec :args (s/cat :x number?) :ret bigdec?)

(s/fdef c/inc :args (s/cat :x number?) :ret number?)
(s/fdef c/dec :args (s/cat :x number?) :ret number?)
(s/fdef c/quot :args (s/cat :num number? :div number?) :ret number?)
(s/fdef c/mod :args (s/cat :num number? :div number?) :ret number?)
(s/fdef c/rem :args (s/cat :num number? :div number?) :ret number?)
(s/fdef c/max :args (s/+ number?) :ret number?)
(s/fdef c/min :args (s/+ number?) :ret number?)

(s/fdef c/+' :args (s/* number?) :ret number?)
(s/fdef c/-' :args (s/+ number?) :ret number?)
(s/fdef c/*' :args (s/* number?) :ret number?)
(s/fdef c/inc' :args (s/cat :x number?) :ret number?)
(s/fdef c/dec' :args (s/cat :x number?) :ret number?)

(s/fdef c/unchecked-char :args (s/cat :x number?) :ret char?)
(s/fdef c/unchecked-byte :args (s/cat :x number?) :ret int?)
(s/fdef c/unchecked-short :args (s/cat :x number?) :ret int?)
(s/fdef c/unchecked-int :args (s/cat :x number?) :ret int?)
(s/fdef c/unchecked-long :args (s/cat :x number?) :ret int?)
(s/fdef c/unchecked-float :args (s/cat :x number?) :ret float?)
(s/fdef c/unchecked-double :args (s/cat :x number?) :ret double?)
(s/fdef c/unchecked-add :args (s/cat :x number? :y number?) :ret number?)
(s/fdef c/unchecked-subtract :args (s/cat :x number? :y number?) :ret number?)
(s/fdef c/unchecked-multiply :args (s/cat :x number? :y number?) :ret number?)
(s/fdef c/unchecked-negate :args (s/cat :x number?) :ret number?)
(s/fdef c/unchecked-inc :args (s/cat :x number?) :ret number?)
(s/fdef c/unchecked-dec :args (s/cat :x number?) :ret number?)
(s/fdef c/unchecked-add-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef c/unchecked-subtract-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef c/unchecked-multiply-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef c/unchecked-divide-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef c/unchecked-remainder-int :args (s/cat :x number? :y number?) :ret int?)
(s/fdef c/unchecked-negate-int :args (s/cat :x number?) :ret int?)
(s/fdef c/unchecked-inc-int :args (s/cat :x number?) :ret int?)
(s/fdef c/unchecked-dec-int :args (s/cat :x number?) :ret int?)

(s/fdef c/bit-not :args (s/cat :x int?) :ret int?)
(s/fdef c/bit-and :args (s/cat :x int? :y int? :more (s/* int?)) :ret int?)
(s/fdef c/bit-or :args (s/cat :x int? :y int? :more (s/* int?)) :ret int?)
(s/fdef c/bit-xor :args (s/cat :x int? :y int? :more (s/* int?) :ret int?))
(s/fdef c/bit-and-not :args (s/cat :x int? :y int? :more (s/* int?)) :ret int?)
(s/fdef c/bit-shift-left :args (s/cat :x int? :n int?) :ret int?)
(s/fdef c/bit-shift-right :args (s/cat :x int? :n int?) :ret int?)
(s/fdef c/unsigned-bit-shift-right :args (s/cat :x int? :n int?) :ret int?)
(s/fdef c/bit-test :args (s/cat :x int? :n int?) :ret boolean?)
(s/fdef c/bit-clear :args (s/cat :x int? :n int?) :ret int?)
(s/fdef c/bit-set :args (s/cat :x int? :n int?) :ret int?)
(s/fdef c/bit-flip :args (s/cat :x int? :n int?) :ret int?)

(s/fdef c/rationalize :args (s/cat :num number?) :ret rational?)
(s/fdef c/numerator :args (s/cat :r ratio?) :ret integer?)
(s/fdef c/denominator :args (s/cat :r ratio?) :ret integer?)
(s/fdef c/rand :args (s/? number?) :ret number?)
(s/fdef c/rand-int :args (s/cat :n int?) :ret int?)

(s/fdef s/empty? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/sequential? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/associative? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/indexed? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/counted? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/sorted? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/reversible? :args (s/cat :coll coll?) :ret boolean?)

(s/fdef c/chunked-seq? :args (s/cat :s seq?) :ret boolean?)

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
