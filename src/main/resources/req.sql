SELECT ExternalTaskObject FROM ExternalTask
INNER JOIN RequestCategory
INNER JOIN ExternalTaskObject
INNER JOIN UniversalObject<Person>
WHERE RequestCategory.COLOR == GREEN AND RequestCategory.id == :id