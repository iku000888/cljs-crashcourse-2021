(ns foo.bar
  (:require [reagent.dom :as rd]
            [reagent.core :as r]
            [ajax.core :refer [GET]]))

(js/alert "foo!")

(comment
  (defn app []
    [:div "hello!!"])

  (rd/render [app]
             (js/document.getElementById "root")))

(comment
  (defn app []
    (r/with-let [a (r/atom 0)]
      [:button {:on-click #(swap! a inc)}
       (str @a)]))

  (rd/render [app]
             (js/document.getElementById "root")))

(comment
  (defn app []
    (r/with-let [a (r/atom nil)]
      [:button {:on-click (fn []
                            (GET "http://localhost:3000"
                                 {:handler (fn [r]
                                             (reset! a r))}))}
       @a]))
  (rd/render [app] (js/document.getElementById "root")))
