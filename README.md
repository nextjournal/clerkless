# clerk-shell

An empty shell of Clerk's Public API.

Intended to be used in when you want to use Clerk to document
a library, but not declare a depdency on it.

## Usage

Override the `:git/url` of your Clerk dependency:

``` clojure
{:deps {io.github.nextjournal/clerk {:git/url "https://github.com/nextjournal/clerk-shell"
                                     :git/sha ",,,"}}}
```

In your dev / doc build, you would override that dep with the normal
Clerk dependency.

