(ns nextjournal.clerk
  "An empty shell of Clerk's Public API.

  Intended to be used in when you want to use Clerk to document a
  library, but not declare a depdency on it.")


(defn show!
  "Evaluates the Clojure source in `file-or-ns` and makes Clerk show it in the browser.

  Accepts ns using a quoted symbol or a `clojure.lang.Namespace`, calls `slurp` on all other arguments, e.g.:

  (nextjournal.clerk/show! \"notebooks/vega.clj\")
  (nextjournal.clerk/show! 'nextjournal.clerk.tap)
  (nextjournal.clerk/show! (find-ns 'nextjournal.clerk.tap))
  (nextjournal.clerk/show! \"https://raw.githubusercontent.com/nextjournal/clerk-demo/main/notebooks/rule_30.clj\")
  (nextjournal.clerk/show! (java.io.StringReader. \";; # Notebook from String 👋\n(+ 41 1)\"))
  "
  [file-or-ns])

(defn recompute!
  "Recomputes the currently visible doc, without parsing it."
  [])







;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; public viewer api


(defn with-viewer
  "Displays `x` using the given `viewer`.

  Takes an optional second `viewer-opts` map arg with the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  ([viewer x])
  ([viewer viewer-opts x]))


(defn with-viewers
  [viewers x])

(defn get-default-viewers
  "Gets Clerk's default viewers."
  [])

(defn add-viewers
  ([added-viewers])
  ([viewers added-viewers]))

(defn update-viewers
  "Takes `viewers` and a `select-fn->update-fn` map returning updated
  viewers with each viewer matching `select-fn` will by updated using
  the function in `update-fn`."
  [viewers select-fn->update-fn])


(defn reset-viewers!
  "Resets the viewers associated with the current `*ns*` to `viewers`."
  [viewers])


(defn add-viewers!
  "Adds `viewers` to the viewers associated with the current `*ns*`."
  [viewers])


(defn ^{:deprecated "0.8"} set-viewers!
  "Deprecated, please use `add-viewers!` instead."
  [viewers])


(defn ->value
  "Takes `x` and returns the `:nextjournal/value` from it, or otherwise `x` unmodified."
  [x])


(defn update-val
  "Take a function `f` and optional `args` and returns a function to update only the `:nextjournal/value` inside a wrapped-value."
  [f & args])


(defn mark-presented
  "Marks the given `wrapped-value` so that it will be passed unmodified to the browser."
  [wrapped-value])


(defn mark-preserve-keys
  "Marks the given `wrapped-value` so that the keys will be passed unmodified to the browser."
  [wrapped-value])


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; public convenience api


(defn html
  "Displays `x` using the html-viewer. Supports HTML and SVG as strings or hiccup.

  Supports an optional first `viewer-opts` map arg with the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  ([x])
  ([viewer-opts x]))

(defn md
  "Displays `x` with the markdown viewer.

  Supports an optional first `viewer-opts` map arg with the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  ([x])
  ([viewer-opts x]))

(defn plotly
  "Displays `x` with the plotly viewer.

  Supports an optional first `viewer-opts` map arg with the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  ([x])
  ([viewer-opts x]))

(defn vl
  "Displays `x` with the vega embed viewer, supporting both vega-lite and vega.

  `x` should be the standard vega view description map, accepting the following addtional keys:
  * `:embed/callback` a function to be called on the vega-embed object after creation.
  * `:embed/opts` a map of vega-embed options (see https://github.com/vega/vega-embed#options)

  Supports an optional first `viewer-opts` map arg with the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  ([x])
  ([viewer-opts x]))

(defn use-headers
  "Treats the first element of the seq `xs` as a header for the table.

  Meant to be used in combination with `table`."
  [xs])

(defn table
  "Displays `xs` using the table viewer.

  Performs normalization on the data, supporting:
  * seqs of maps
  * maps of seqs
  * seqs of seqs

  If you want a header for seqs of seqs use `use-headers`.

  Supports an optional first `viewer-opts` map arg with the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  ([xs])
  ([viewer-opts xs]))

(defn row
  "Displays `xs` as rows.

  Treats the first argument as `viewer-opts` if it is a map but not a `wrapped-value?`.

  The `viewer-opts` map can contain the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  [& xs])

(defn col
  "Displays `xs` as columns.

  Treats the first argument as `viewer-opts` if it is a map but not a `wrapped-value?`.

  The `viewer-opts` map can contain the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  [& xs])

(defn tex
  "Displays `x` as LaTeX using KaTeX.

  Supports an optional first `viewer-opts` map arg with the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  ([x])
  ([viewer-opts x]))

(defn hide-result
  "Deprecated, please put `^{:nextjournal.clerk/visibility {:result :hide}}` metadata on the form instead."
  {:deprecated "0.10"}
  ([x])
  ([viewer-opts x]))


(defn code
  "Displays `x` as syntax highlighted Clojure code.

  A string is shown as-is, any other arg will be pretty-printed via `clojure.pprint/pprint`.

  Supports an optional first `viewer-opts` map arg with the following optional keys:

  * `:nextjournal.clerk/width`: set the width to `:full`, `:wide`, `:prose`
  * `:nextjournal.clerk/viewers`: a seq of viewers to use for presentation of this value and its children
  * `:nextjournal.clerk/opts`: a map argument that will be passed to the viewers `:render-fn`"
  ([code-string-or-form])
  ([viewer-opts code-string-or-form]))

(defn eval-cljs-str
  "Evaluates the given ClojureScript `code-string` in the browser."
  [code-string])


(defn doc-url [path])

(defmacro example
  "Evaluates the expressions in `body` showing code next to results in Clerk.

  Does nothing outside of Clerk, like `clojure.core/comment`."
  [& body])

(defn file->viewer
  "Evaluates the given `file` and returns it's viewer representation."
  ([file])
  ([opts file]))

#_(file->viewer "notebooks/rule_30.clj")

(defn halt-watcher!
  "Halts the filesystem watcher when active."
  [])


(defn serve!
  "Main entrypoint to Clerk taking an configurations map.

  Will obey the following optional configuration entries:

  * a `:port` for the webserver to listen on, defaulting to `7777`
  * `:browse?` will open Clerk in a browser after it's been started
  * a sequence of `:watch-paths` that Clerk will watch for file system events and show any changed file
  * a `:show-filter-fn` to restrict when to re-evaluate or show a notebook as a result of file system event. Useful for e.g. pinning a notebook. Will be called with the string path of the changed file.

  Can be called multiple times and Clerk will happily serve you according to the latest config."
  [config])

(defn halt!
  "Stops the Clerk webserver and file watcher."
  [])

(defn valuehash [x])

(defn build!
  "Creates a static html build from a collection of notebooks.

  Options:
  - `:paths`     - a vector of relative paths to notebooks to include in the build
  - `:paths-fn`  - a symbol resolving to a 0-arity function returning computed paths
  - `:index`     - a string allowing to override the name of the index file, will be added to `:paths`

  Passing at least one of the above is required. When both `:paths`
  and `:paths-fn` are given, `:paths` takes precendence.

  - `:bundle`      - if true results in a single self-contained html file including inlined images
  - `:compile-css` - if true compiles css file containing only the used classes
  - `:ssr`         - if true runs react server-side-rendering and includes the generated markup in the html
  - `:browse`      - if true will open browser with the built file on success
  - `:dashboard`   - if true will start a server and show a rich build report in the browser (use with `:bundle` to open browser)
  - `:out-path`  - a relative path to a folder to contain the static pages (defaults to `\"public/build\"`)
  - `:git/sha`, `:git/url` - when both present, each page displays a link to `(str url \"blob\" sha path-to-notebook)`
  "
  [build-opts])


(defn clear-cache!
  "Clears the in-memory and file-system caches when called with no arguments.

  Clears the cache for a single result identitfied by `sym-or-form` argument which can be:
  * a symbol representing the var name (qualified or not)
  * the form of an anonymous expression"
  ([])
  ([sym-or-form]))
