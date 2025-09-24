/* BEGIN Package ----- */
package template
/* END Package ----- */

import (
    "github.com/sderkacs/exi-go/core"
    "github.com/sderkacs/exi-go/utils"
)

type Grammars2GoSourceCodeTemplate struct {
    schemaID       *string
    grammarContext *core.GrammarContext
    document       *core.Document
    fragment       *core.Fragment
    sief           core.SchemaInformedGrammar
}

func NewGrammars2GoSourceCodeTemplate() (*Grammars2GoSourceCodeTemplate, error) {
    /* BEGIN GrammarContext ----- */
    /* END GrammarContext ----- */

    /* BEGIN Grammars ----- */
    /* END Grammars ----- */

	/* BEGIN Grammars with element content ----- */
	/* END Grammars with element content ----- */

	/* BEGIN Globals ----- */
	/* END Globals ----- */

    /* BEGIN GlobalElements ----- */
    /* END GlobalElements ----- */

    /* BEGIN GlobalAttributes ----- */
    /* END GlobalAttributes ----- */

    /* BEGIN TypeGrammar ----- */
    /* END TypeGrammar ----- */

    /* BEGIN Grammar Events ----- */
    /* END Grammar Events ----- */

    /* BEGIN FirstStartGrammar ----- */
    /* END FirstStartGrammar ----- */

    /* BEGIN GrammarStructInit ----- */
    return &Grammars2GoSourceCodeTemplate{}, nil
    /* END GrammarStructInit ----- */
}

func (g *Grammars2GoSourceCodeTemplate) IsSchemaInformed() bool {
    return true
}

func (g *Grammars2GoSourceCodeTemplate) GetSchemaID() *string {
    return g.schemaID
}

func (g *Grammars2GoSourceCodeTemplate) SetSchemaID(schemaID *string) error {
    g.schemaID = schemaID
    return nil
}

func (g *Grammars2GoSourceCodeTemplate) IsBuiltInXMLSchemaTypesOnly() bool {
    return false
}

func (g *Grammars2GoSourceCodeTemplate) GetDocumentGrammar() core.Grammar {
    return g.document
}

func (g *Grammars2GoSourceCodeTemplate) GetFragmentGrammar() core.Grammar {
    return g.fragment
}

func (g *Grammars2GoSourceCodeTemplate) GetGrammarContext() *core.GrammarContext {
    return g.grammarContext
}

func (g *Grammars2GoSourceCodeTemplate) GetSchemaInformedGrammars() (*core.SchemaInformedGrammars, error) {
    gs := core.NewSchemaInformedGrammars(g.grammarContext, g.document, g.fragment, g.sief)
    if err := gs.SetSchemaID(g.schemaID); err != nil {
        return nil, err
    }
    return gs, nil
}
