package es.um.uschema.xtext.athena.utils.compare

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2

abstract class Comparator<T>
{
  def boolean compare(T o1, T o2)

  def boolean checkNulls(T o1, T o2)
  {
    return o1 === null || o2 === null
  }

  def boolean checkEquals(T o1, T o2)
  {
    return o1 == o2 || o1.equals(o2) || EcoreUtil2.equals(o1 as EObject, o2 as EObject)
  }
}
