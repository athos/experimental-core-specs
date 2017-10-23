(ns experimental-core-specs.core
  (:require [clojure.core :as c]
            [clojure.spec.alpha :as s])
  (:import [clojure.lang IChunk ChunkBuffer]))

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
  c/sequential?
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

(s/fdef c/symbol
  :args (s/alt :1 (s/cat :name (s/alt :sym symbol? :str string?))
               :2 (s/cat :ns string? :name string?))
  :ret symbol?)
(s/fdef c/keyword
  :args (s/alt :1 (s/cat :name (s/alt :kw keyword?
                                      :sym symbol?
                                      :str string?))
               :2 (s/cat :ns string? :name string?))
  :ret keyword?)
(s/fdef c/namespace
  :args (s/cat :x (s/alt :sym symbol? :kw keyword?))
  :ret (s/nilable string?))
(s/fdef c/name
  :args (s/cat :x (s/alt :str string? :kw keyword? :sym symbol?))
  :ret string?)
(s/fdef c/gensym
  :args (s/alt :0 (s/cat)
               :1 (s/cat :prefix-string (s/alt :str string? :sym symbol?)))
  :ret symbol?)

(s/fdef s/empty? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/associative? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/indexed? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/counted? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/sorted? :args (s/cat :coll coll?) :ret boolean?)
(s/fdef c/reversible? :args (s/cat :coll coll?) :ret boolean?)

(s/fdef c/seq :args (s/cat :coll seqable?) :ret (s/nilable seq?))
(s/fdef c/cons :args (s/cat :x any? :seq seqable?) :ret seq?)
(s/fdef c/first :args (s/cat :coll seqable?) :ret (s/nilable any?))
(s/fdef c/next :args (s/cat :coll seqable?) :ret (s/nilable seq?))
(s/fdef c/rest :args (s/cat :coll seqable?) :ret seq?)
(s/fdef c/ffirst :args (s/cat :x seqable?) :ret (s/nilable any?))
(s/fdef c/fnext :args (s/cat :x seqable?) :ret (s/nilable any?))
(s/fdef c/nfirst :args (s/cat :x seqable?) :ret (s/nilable seq?))
(s/fdef c/nnext :args (s/cat :x seqable?) :ret (s/nilable seq?))
(s/fdef c/nth
  :args (s/cat :coll (s/alt :seq seq? :indexed indexed?)
               :index int?
               :not-found (s/? any?))
  :ret any?)
(s/fdef c/nthnext :args (s/cat :coll seqable? :n int?) :ret (s/nilable seq?))
(s/fdef c/nthrest :args (s/cat :coll seqable? :n int?) :ret seq?)
(s/fdef c/take
  :args (s/cat :n int? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/drop
  :args (s/cat :n int? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/take-while
  :args (s/cat :pred ifn? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/drop-while
  :args (s/cat :pred ifn? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/last :args (s/cat :coll seqable?) :ret any?)
(s/fdef c/butlast :args (s/cat :coll seqable?) :ret (s/nilable seq?))
(s/fdef c/take-last :args (s/cat :n int? :coll seqable?) :ret (s/nilable seq?))
(s/fdef c/drop-last :args (s/cat :n int? :coll seqable?) :ret seq?)
(s/fdef c/take-nth
  :args (s/cat :n int :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/count :args (s/cat :coll seqable?) :ret int?)
(s/fdef c/concat :args (s/* seqable?) :ret seq?)
(s/fdef c/seque
  :args (s/cat :n-or-q (s/? (s/alt :n int?
                                   :q #(instance? java.util.concurrent.BlockingQueue %)))
               :s seqable?)
  :ret seq?)
(s/fdef c/sequence
  :args (s/alt :1 (s/cat :coll seqable?)
               :2+ (s/cat :xform fn? :colls (s/+ seqable?)))
  :ret seq?)
(s/fdef c/reduce
  :args (s/alt :without-init (s/cat :f ifn? :coll seqable?)
               :with-init (s/cat :f ifn? :val any? :coll seqable?))
  :ret any?)
(s/fdef c/map
  :args (s/alt :xform (s/cat :f ifn?)
               :seq (s/cat :f ifn? :colls (s/* seqable?)))
  :ret seq?)
(s/fdef c/filter
  :args (s/cat :pred ifn? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/remove
  :args (s/cat :pred ifn? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/keep
  :args (s/cat :f ifn? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/mapcat
  :args (s/cat :f ifn? :colls (s/* seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/map-indexed
  :args (s/cat :f ifn? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/keep-indexed
  :args (s/cat :f ifn? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/some :args (s/cat :pred ifn? :coll seqable?) :ret any?)
(s/fdef c/every? :args (s/cat :pred ifn? :coll seqable?) :ret boolean?)
(s/fdef c/not-any? :args (s/cat :pred ifn? :coll seqable?) :ret boolean?)
(s/fdef c/not-every? :args (s/cat :pred ifn? :coll seqable?) :ret boolean?)
(s/fdef c/doall :args (s/cat :n (s/? int?) :coll seqable?) :ret seq?)
(s/fdef c/dorun :args (s/cat :n (s/? int?) :coll seqable?) :ret nil?)
(s/fdef c/run! :args (s/cat :proc ifn? :coll seqable?) :ret nil?)
(s/fdef c/reverse :args (s/cat :coll seqable?) :ret seq?)
(s/fdef c/dedupe
  :args (s/cat :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/distinct
  :args (s/cat :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/range
  :args (s/alt :0 (s/cat)
               :1 (s/cat :end integer?)
               :2 (s/cat :start integer? :end integer?)
               :3 (s/cat :start integer? :end integer? :step integer?))
  :ret seq?)
(s/fdef c/cycle :args (s/cat :coll seqable?) :ret seq?)
(s/fdef c/repeat :args (s/cat :n (s/? int?) :x any?) :ret seq?)
(s/fdef c/replicate :args (s/cat :n (s/? int?) :x any?) :ret seq?)
(s/fdef c/repeatedly :args (s/cat :n (s/? int?) :x ifn?) :ret seq?)
(s/fdef c/iterate :args (s/cat :f ifn? :x any?) :ret seq?)
(s/fdef c/interpose :args (s/cat :sep any? :coll seqable?) :ret seq?)
(s/fdef c/interleave :args (s/* seqable?) :ret seq?)
(s/fdef c/reductions
  :args (s/cat :f ifn? :init (s/? any?) :coll seqable?)
  :ret seq?)
(s/fdef c/split-at :args (s/cat :n int? :coll seqable?) :ret vector?)
(s/fdef c/split-with :args (s/cat :pred ifn? :coll seqable?) :ret vector?)
(s/fdef c/frequencies :args (s/cat :coll seqable?) :ret map?)
(s/fdef c/group-by :args (s/cat :f ifn? :coll seqable?) :ret map?)
(s/fdef c/partition
  :args (s/alt :2 (s/cat :n int? :coll seqable?)
               :3 (s/cat :n int? :step int? :coll seqable?)
               :4 (s/cat :n int? :step int? :pad seqable? :coll seqable?))
  :ret seq?)
(s/fdef c/partition-by
  :args (s/cat :f ifn? :coll (s/? seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/partition-all
  :args (s/alt :1 (s/cat :n int?)
               :2 (s/cat :n int? :coll seqable?)
               :3 (s/cat :n int? :step int? :coll seqable?))
  :ret (s/or :seq seq? :xform fn?))
(s/fdef c/sort :args (s/cat :comp (s/? ifn?) :coll seqable?) :ret seq?)
(s/fdef c/sort-by
  :args (s/cat :keyfn ifn? :comp (s/? ifn?) :coll seqable?)
  :ret seq?)
(s/fdef c/tree-seq
  :args (s/cat :branch? ifn? :children ifn? :root any?)
  :ret seq?)
(s/fdef c/re-seq
  :args (s/cat :re #(instance? java.util.regex.Pattern %) :s string?)
  :ret seq?)
(s/fdef c/iterator-seq
  :args (s/cat :iter #(instance? java.util.Iterator %))
  :ret seq?)
(s/fdef c/enumeration-seq
  :args (s/cat :e #(instance? java.util.Enumeration %))
  :ret seq?)
(s/fdef c/line-seq
  :args (s/cat :rdr #(instance? java.io.BufferedReader %))
  :ret seq?)
(s/fdef c/file-seq
  :args (s/cat :dir #(instance? java.io.File %))
  :ret seq?)
(s/fdef c/resultset-seq
  :args (s/cat :rs #(instance? java.sql.ResultSet %))
  :ret seq?)

(s/fdef c/chunked-seq? :args (s/cat :s seq?) :ret boolean?)
(s/fdef c/chunk-buffer
  :args (s/cat :capacity int?)
  :ret #(instance? ChunkBuffer %))
(s/fdef c/chunk-append
  :args (s/cat :b #(instance? ChunkBuffer %) :x any?)
  :ret #(instance? IChunk %))
(s/fdef c/chunk
  :args (s/cat :b #(instance? ChunkBuffer %))
  :ret #(instance? IChunk %))
(s/fdef c/chunk-cons
  :args (s/cat :chunk #(instance? IChunk %) :rest seqable?)
  :ret seq?)
(s/fdef c/chunk-first :args (s/cat :s chunked-seq?) :ret any?)
(s/fdef c/chunk-next :args (s/cat :s chunked-seq?) :ret (s/nilable seq?))
(s/fdef c/chunk-rest :args (s/cat :s chunked-seq?) :ret seq?)

(s/def ::namespace
  (s/spec #(instance? clojure.lang.Namespace %)))
(s/def ::ns-or-sym
  (s/or :ns ::namespace :sym simple-symbol?))

(s/fdef c/all-ns :args (s/cat) :ret (s/every ::namespace))
(s/fdef c/find-ns :args (s/cat :sym symbol?) :ret (s/nilable ::namespace))
(s/fdef c/the-ns :args (s/cat :x ::ns-or-sym) :ret ::namespace)
(s/fdef c/ns-name :args (s/cat :ns ::ns-or-sym) :ret simple-symbol?)
(s/fdef c/ns-map
  :args (s/cat :ns ::ns-or-sym)
  :ret (s/map-of simple-symbol? var?))
(s/fdef c/ns-publics
  :args (s/cat :ns ::ns-or-sym)
  :ret (s/map-of simple-symbol? var?))
(s/fdef c/ns-interns
  :args (s/cat :ns ::ns-or-sym)
  :ret (s/map-of simple-symbol? var?))
(s/fdef c/ns-refers
  :args (s/cat :ns ::ns-or-sym)
  :ret (s/map-of simple-symbol? var?))
(s/fdef c/ns-aliases
  :args (s/cat :ns ::ns-or-sym)
  :ret (s/map-of simple-symbol? ::namespace))
(s/fdef c/ns-imports
  :args (s/cat :ns ::ns-or-sym)
  :ret (s/map-of simple-symbol? class?))
(s/fdef c/in-ns :args (s/cat :name simple-symbol?))
(s/fdef c/create-ns :args (s/cat :sym simple-symbol?) :ret ::namespace)
(s/fdef c/ns-resolve
  :args (s/cat :ns ::ns-or-sym
               :env (s/? (s/map-of simple-symbol? any?))
               :sym symbol?)
  :ret (s/or :var var? :class class?))
(s/fdef c/resolve
  :args (s/cat :env (s/? (s/map-of simple-symbol? any?))
               :sym symbol?)
  :ret (s/or :var var? :class class?))
(s/fdef c/intern
  :args (s/cat :ns ::ns-or-sym :name simple-symbol? :val any?)
  :ret var?)
(s/fdef c/find-keyword
  :args (s/alt :1 (s/cat :name (s/alt :kw keyword?
                                      :sym symbol?
                                      :str string?))
               :2 (s/cat :ns string? :name string?))
  :ret (s/nilable keyword?))
(s/fdef c/ns-unmap :args (s/cat :ns ::ns-or-sym :sym simple-symbol?))
(s/fdef c/ns-unalias :args (s/cat :ns ::ns-or-sym :sym simple-symbol?))
(s/fdef c/remove-ns :args (s/cat :sym simple-symbol?))

(comment

subseq
rseq
rsubseq
find
filterv
bound?
restart-agent
macroexpand
ensure
eduction
get-thread-bindings
contains?
proxy-mappings
subs
ref-min-history
set
reader-conditional
->Eduction
satisfies?
re-groups
println-str
with-bindings*
inst-ms
slurp
newline
short-array
prefers
dissoc
atom
print-method
peek
aget
pr
push-thread-bindings
bases
thread-bound?
send-via
boolean
find-var
aclone
vreset!
future-call
struct
juxt
test
ex-data
compile
isa?
munge
set-error-mode!
make-hierarchy
set-agent-send-executor!
swap-vals!
char
aset-long
some?
rand-nth
comp
await
spit
future-done?
disj
eval
refer
print-dup
floats
fnil
merge-with
load
shuffle
boolean-array
alength
deliver
var-set
pmap
error-mode
disj!
aset-float
bean
booleans
int-array
cat
StackTraceElement->vec
flush
vary-meta
alter
conj!
zipmap
reset-vals!
alter-var-root
re-pattern
pop!
prn-str
format
shutdown-agents
conj
transduce
compare-and-set!
await1
ref-set
pop-thread-bindings
printf
get
identity
into
meta
find-protocol-impl
method-sig
hash-ordered-coll
reset-meta!
hash
read
key
longs
aset-double
pcalls
remove-all-methods
aset-boolean
trampoline
vec
second
vector-of
hash-combine
replace
set-error-handler!
inst-ms*
force
bound-fn*
namespace-munge
prn
extend
->VecSeq
Inst
double-array
re-matcher
ref
extends?
promise
aset-char
construct-proxy
agent-errors
pr-str
aset-short
set-agent-send-off-executor!
to-array-2d
pop
use
dissoc!
aset-byte
ref-history-count
assoc!
hash-set
reduce-kv
cast
reset!
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
add-watch
agent-error
future-cancelled?
struct-map
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
val
loaded-libs
->Vec
not
with-meta
unreduced
type
max-key
agent
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
not-empty
add-classpath
long-array
descendants
merge
accessor
mapv
object-array
derive
load-string
ancestors
error-handler
print-simple
flatten
doubles
halt-when
remove-watch
ex-info
proxy-name
find-protocol-method
subvec
partial
min-key
reduced
char-escape-string
re-matches
array-map
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
read-string
get-method
list
aset
->VecNode
destructure
chars
str
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
supers
sorted-map-by
apply
deref
assoc
transient
clojure-version
comparator
sorted-map
send
proxy-call-with-super
realized?
char-array
compare
complement
with-redefs-fn
constantly
get-proxy-class
make-array
shorts
completing
update-proxy
hash-unordered-coll
create-struct
get-validator
await-for
print-str
into-array
init-proxy
future-cancel
var-get
commute
get-in
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
