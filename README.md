# dude
A modest grocery list that will not let you forget you milk (or Kahlua)

# The dude aims to be
* a webbased grocery list
* simple and stupid as f$§%
* yet pretty sly

In it's first stage the dude will be a nice restful server and a cute web interface ( TODO change "will be" to "is" as soon as we actually did it). An android app might follow.

This project is done by two dudes who want to "do some scala again". So it will be scala, scala-js and all the stuff we ever wanted to use/try. Deal with it.

# Server
TODO pretend to have a REST API and change it throughout the project.

## Basic operations
* add an item
* mark an item as bought/done
* retrieve a list of current items (the stuff you need to buy)
* retrieve a list of past/done items (to be resued/reactivated when you are compiling what you need now)
* delete an item so it's no longer in your list of past items

## Items
Items consist of 
* a mandatory textual description
* an optional quantity
* an optional comment (if you can't seem to remember which mozarella your girlfriend wants)
Note: when persisting an item as "past item" the quantity should probably omitted (Just because I need 2 liters of milk NOW does not mean that I need 2 liters of milk next time)


## Login/Authentification
No login required. Use "doodle-like" way to "just create" a list with some random url that can be shared among friends and spouses. 

## Ordering/Views
Every user of a certain list should be able to create his personal view by putting the items in any order that fit's her needs best. Since none is really authenticated, everybody can see/edit every view of the list. This also opens the possiblity of collectively managed views.

### View operations
* create view
* (de)select view
* move items around within a view
* delete view

# Client
Some loose mission statements:
* should be streamlined not to get in your way or on your nerves while shopping
* reliable in the face of shitty internet connections (they always are in supermarkets)
* should give you emediate feedback at all times
* should also support a no-javascript mode (or do YOU want to fire up a X-server just to add baked beans to your list?)

## Design
The interface (which is inspired by Notational Velocity) consists of 3 elements
* the search/create bar
* the shopping list
* the old list
TODO add view management to this draft.

### Searchbar
When opening the client the focus is on this element. Typing text starts filtering the items of both the shopping and the old list. When pressing return a new item is created with the text given; the search/create bar is emtptied.

### Shopping list
A list of all items that you need to buy. Ordered by the current view. New items that have not been manually ordered are always on top. When no view is selected the items are ordered by last create/add date; newest first.

### The old list
A list of items that been finished/bought. Ordered by last finished/bought date; newest first.

## Usage of the lists
In both lists right clicking and item or pressing it for some time (let's say 1 second) lets you edit the item
### shopping list
#### Clicking items
Clicking an item changes the colour of it, giving emediate feedback. The server is not contacted right away but a timer is started. If the item is clicked again within a timeout (about 2 seconds) the timer is stoped without contacting the server. This allows to correct bad clicks. If the timeout has passed the color changes to some signaling colour to show that now the server has been contacted. When the response from the server arrives the item slides down to the old list.
#### Dragging items
Only supported when a view has been selected (auto create view on dragging?). Changes order within the view.
### old list
#### Clicking items
When clicking an item the user might be prompted for a quantity. The item changes color and slides up to the top of the shopping list as soon as the response from the server arrived.

## Persisting actions
When the connection to the server times out on list actions, the client keeps trying to push the changes to server until it succeeds.
