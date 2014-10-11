package partE;

public class PartE {
/*
 * BulkContainer is a subclass of BulkItem, where all the methods
 * inherited are the same, but some altered slightly to more appropriately
 * fit the model for a container. Super/subclasses work best when the subclass
 * merely adds on to what already exists. For example, when classifying 
 * the directions of cleaningRegularClothes, one may wash and dry.  When
 * one wishes to provide directions for cleaningProfessionalClothes, one
 * may wash and dry, but in addition, iron and hang their clothes. Meanwhile, 
 * Package and ManyPackages take similar methods and fields, but here, the 
 * polymorphism only comes from the interface.  The reason for this is because
 * while it makes sense to include all the information of a BulkItem in the 
 * BulkContainer (because the Item is quite literally in the container and so 
 * we should account for that), many packages does not necessarily mean that 
 * there are many packages of a package.  For example, it is possible to have
 * a package of avocados, but also have many packages for a crate of apples. 
 * 
 * 
 *Determining whether the name of an item matches a desired name
 * First approach: directly access the name field of each class
 * 	If you access the name field of each class, there will always be 
 *  a specific distinction of what name is coming from where, but as 
 *  you mentioned, it would be very difficult to access these methods
 *  if they are private.
 * 
 * Second approach: write a getName method for each class
 * 	Writing a getName method might be advantageous if the name retrieved 
 *  requires different elements for it, and would include polymorphism 
 *  between classes and constructors.  However, this method might be better 
 *  if it was put in an interface, so this might be redundant.  In addition, 
 *  I don't see how the objective of name matching could be implemented without
 *  some sort of compare method.
 * 
 * Third: approach: write an equals(String name) method for each appropriate 
 *  class 
 *  This might be the most straightforward in determining whether the name of 
 * 	an item matches a class.  I'm not sure if there are any disadvantages...
 * 
 * Fourth approach: write a hasName(String name) method for each class
 * 	A hasName class might check if there is a name, but I think it would 
 *  make more sense to just use this case as an initial checker if there
 *  in any string comparison class.
 *  
 * I personally think that a Package could work for NonFood as well as food,
 * since the fields are the same.  It doesn't matter what is in the package, 
 * only what is the weight and price etc.  In terms of a package, we are 
 * looking at the box, not what is in the box. However, the classes should
 * be kept separate when it comes to looking at the actual product itself.
 * 
 * The package could use a field "content" to determine what is in the box,
 * and even have a shelf life (to distinguish between perishable and 
 * nonperishable) so that some foods like dried fruits could go on the same
 * shelf as other products and whatnot. In making more maintainable food, we
 * need to be able to organize our packages in the form of an inventory, which 
 * might require another class. 
 * 
 * Looking at Walker's design, this design is more specific and the layout of 
 * the items make more sense to me compared to the other design.  However, 
 * these appear to only account for individual packages and individual items 
 * rather than bulk items, which might not be terrbly efficient.
 *  
 */
}
