use library

document = ( { Type : "Book", Title : "Definitive Guide to MongoDB", ISBN :
"987-1-4302-3051-9", Publisher : "Apress", Author: ["Membrey, Peter",
"Plugge, Eelco", "Hawkins, Tim" ] } )

db.media.insert(document)

db.media.insert( { Type : "CD" ,Artist : "Nirvana",Title : "Nevermind",
Tracklist : [
{ Track : "1 ", Title : "Smells like teen spirit", Length : "5:02 "}, { Track : "2 ",
Title : "In Bloom", Length : "4:15 " }
]} )

document = ( { Type : "Book",Title : "Definitive Guide to MongoDB", ISBN: "1-4302-3051-7", Publisher : "Apress", Author : ["Membrey, Peter","Plugge, Eelco","Hawkins, Tim"] } )

dvd = ( { Type : "DVD", Title : "Matrix, The", Released : 1999, Cast: ["Keanu Reeves","Carry-Anne Moss","Laurence Fishburne","Hugo Weaving","Gloria Foster","Joe Pantoliano"] } )

function insertMedia( type, Ytle, released ){ db.media.insert({ "Type": type, "Title": Ytle, "Released": released }); }

db.media.find( { ISBN: "987-1-4302-3051-9"} ) . hint ( { ISBN: -1 } ) error: { "$err" : "bad hint", "code" : 10113 } 
db.media.ensureIndex({ISBN: 1})

db.earthquakes.find().forEach( function(eq){ eq.properties.iso_date = new Date(eq.properties.time); db.earthquakes.save(eq); } );

db.earthquakes.find().forEach( function(eq){
    var str = new String(eq.properties.types);
    eq.properties.types_as_array = str.split(",");
    db.earthquakes.save(eq);
} )

db.earthquakes.update({},{ $pullAll: { "properties.types_as_array" : [""] } },{ multi: true })

db.earthquakes.find({
  "geometry.coordinates": {
    $geoWithin: {
      $center: [
        [-74, 40.74],  
        1000          
      ]
    }
  }
}).limit(1)

db.earthquakes.find({
  "geometry.coordinates": {
    $geoWithin: {
      $box: [
        [-122.933 - 4.5, 38.872 - 4.5], 
        [-122.933 + 4.5, 38.872 + 4.5]  
      ]
    }
  }
}).limit(1)
